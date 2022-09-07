#include <iostream>
using namespace std;

struct Paciente
{
	string nombre;
	bool medico;
	int edad;
	string vacuna;
};

struct node
{
	Paciente data;
	node *prev;
	node *next;

	node(Paciente p)
	{
		data = p;
		prev = NULL;
		next = NULL;
	}
};
class DoubleList
{
	node *PTR = NULL;
	node *ULT = NULL;

public:
	bool vacia();
	void insertarInicio(Paciente x);
	void insertarFinal(Paciente x);
	void mostrar();

	void eliminarFinal();
	void eliminarInicio();
	void eliminar(string nombre);

	int cantidad();
	Paciente obtener(int pos);
};

bool DoubleList::vacia()
{
	return (PTR == NULL);
}

void DoubleList::insertarInicio(Paciente p)
{
	node *nuevo = new node(p);

	if (vacia())
	{
		PTR = ULT = nuevo;
	}
	else
	{
		nuevo->next = PTR;
		PTR->prev = nuevo;
		PTR = nuevo;
	}
}

void DoubleList::insertarFinal(Paciente p)
{
	node *nuevo = new node(p);

	if (vacia())
	{
		PTR = ULT = nuevo;
	}
	else
	{
		ULT->next = nuevo;
		nuevo->prev = ULT;
		ULT = nuevo;
	}
}

void DoubleList::mostrar()
{
	if (!vacia())
	{
		node *p = PTR;
		while (p != NULL)
		{
			string tipo = " ";
			if (p->data.medico)
			{
				tipo = " (Medico) ";
			}

			cout << " " << p->data.nombre << " - " << p->data.edad << tipo << "(" << p->data.vacuna << ")\n";
			p = p->next;
		}
	}
}

void DoubleList::eliminarFinal()
{
	if (!vacia())
	{
		node *p = PTR;

		if (PTR == ULT)
		{
			PTR = ULT = NULL;
		}
		else
		{
			p = ULT;
			ULT->prev->next = NULL;
			ULT = ULT->prev;
		}
		delete p;
	}
}

void DoubleList::eliminarInicio()
{
	if (!vacia())
	{
		node *p = ULT;
		if (PTR == ULT)
		{
			PTR = ULT = NULL;
		}
		else
		{
			p = PTR;
			p->next->prev = NULL;
			PTR = PTR->next;
		}
		delete p;
	}
}

void DoubleList::eliminar(string nombre)
{
	if (PTR->data.nombre == nombre)
	{
		eliminarInicio();
	}
	else if (ULT->data.nombre == nombre)
	{
		eliminarFinal();
	}
	else if (!vacia())
	{
		node *p = PTR->next;
		while (p != NULL)
		{
			if (p->data.nombre == nombre)
			{
				p->prev->next = p->next;
				p->next->prev = p->prev;
				delete p;
				break;
			}
			p->prev = p;
			p = p->next;
		}
	}
}

int DoubleList::cantidad()
{
	node *p = PTR;
	int cant = 0;
	while (p != NULL)
	{
		p = p->next;
		cant++;
	}
	return cant;
}

Paciente DoubleList::obtener(int pos)
{
	if (!vacia())
	{
		node *p = PTR;
		int i = 0;
		while (p != NULL && i != pos)
		{
			p = p->next;
			i++;
		}
		return p->data;
	}
}

int main()
{
	DoubleList l;
	DoubleList lMedico;
	DoubleList lMayor60;
	int op;
	Paciente p;
	string temp;
	int totalPersonas = 0;
	int pacientesNoIngresados = 0;
	int pfizer = 0;
	int astrazeneca = 0;
	int sinovac = 0;

	while (op != -1)
	{
		cout << "\n 1. Ingresar paciente\n";
		cout << " 2. Listar pacientes\n";
		cout << " 3. Listar personal medico\n";
		cout << " 4. Listar pacientes mayores de 60\n";
		cout << " 5. Porcentaje de vacunas del tipo\n";
		cout << " 6. Vacunar\n";
		cout << " 7. Personas que quedaron fuera\n";
		cout << " (digite -1 para salir): ";
		cin >> op;
		cout << "\n";

		switch (op)
		{
		case 1:
			cout << " Ingrese los datos del paciente\n";

			cout << " Nombre: ";
			cin >> p.nombre;

			cout << " Es medico?  [s/n]: ";
			cin >> temp;
			p.medico = (temp == "s") ? true : false;

			cout << " Edad: ";
			cin >> p.edad;

			cout << " Vacuna: ";
			cin >> p.vacuna;

			if (p.medico)
			{
				l.insertarInicio(p);
				lMedico.insertarInicio(p);
				if (p.vacuna == "pfizer")
				{
					pfizer++;
				}
				else if (p.vacuna == "astrazeneca")
				{
					astrazeneca++;
				}
				else
				{
					sinovac++;
				}
			}
			else if (p.edad > 60)
			{
				l.insertarFinal(p);
				lMayor60.insertarInicio(p);
				if (p.vacuna == "pfizer")
				{
					pfizer++;
				}
				else if (p.vacuna == "astrazeneca")
				{
					astrazeneca++;
				}
				else
				{
					sinovac++;
				}
			}
			else
			{
				pacientesNoIngresados++;
			}
			
			totalPersonas++;
			break;

		case 2:
			l.mostrar();
			break;

		case 3:
			lMedico.mostrar();
			break;

		case 4:
			lMayor60.mostrar();
			break;

		case 5:
			cout << " Tipo de vacuna [p(pfizer) / a(astrazeneca) / s(sinovac)] :";
			cin >> temp;

			if (temp == "p")
			{
				cout << " " << pfizer * 100 / l.cantidad() << " % de vacunas aplicadas son pfizer";
			}
			else if (temp == "a")
			{
				cout << " " << astrazeneca * 100 / l.cantidad() << " % de vacunas aplicadas son astrazeneca";
			}
			else
			{
				cout << " " << sinovac * 100 / l.cantidad() << " % de vacunas aplicadas son sinovac";
			}

			break;

		case 6:
			cout << " Ingrese el nombre del paciente: ";
			cin >> temp;
			l.eliminar(temp);
			break;

		case 7:
			cout << " " << pacientesNoIngresados * 100 / totalPersonas << " % de las personas no ingreso";
			break;
		}
	}

	return 1;
}
