#include<iostream>
using namespace std;

struct node {
	int data;
	node *next;
};

class LinkedList {
	node *PTR = NULL;
	public:
		bool vacia();
		void insertarFinal(int x);
		void mostrar();
		void eliminarInicio();
		void eliminarFinal();
		void insertarInicio(int x);
		int cantidad();
		bool buscar(int x);
		
		void eliminar(int x);
		int obtener(int pos);
		
		void insertarDespues(int x, int y);
		void insertarAntes(int x, int y);
};

bool LinkedList::vacia(){
	return (PTR == NULL);
}

void LinkedList::insertarFinal(int x){
	node *nuevo = new node;
	nuevo->data = x;
	nuevo->next = NULL;
	if(vacia()){
		PTR = nuevo;
	} else {
		node *p = PTR;
		while(p->next != NULL){
			p = p->next;
		}
		p->next = nuevo;
	}
}

void LinkedList::mostrar(){
	if(!vacia()){
		node *p = PTR;
		while(p != NULL){
			cout << " " << p->data;
			p = p->next;
		}
	}
}

void LinkedList::eliminarInicio(){
	if(!vacia()){
		node *p = PTR;
		PTR = PTR->next;
		p->next = NULL;
		delete p;
	}
}

void LinkedList::eliminarFinal(){
	if(!vacia()){
		node *p = PTR;
		node *q = p;
		if(PTR->next == NULL){
			PTR = NULL;
		}else{
			while(p->next != NULL){
				q = p;
				p = p->next;
			}	
			q->next = NULL;
		}
		delete p;
	}	
}

void LinkedList::insertarInicio(int x) {	
	if(vacia()){
		insertarFinal(x);
	} else {
		node *nuevo = new node;
		nuevo->data = x;
		nuevo->next = PTR;
		PTR = nuevo;
	}
}

int LinkedList::cantidad(){
	int cant = 0;
	node *p = PTR;
	while(p != NULL){
		p = p->next;
		cant++;
	}
	return cant;
}

bool LinkedList::buscar(int x){
	bool encontrado = false;
	node *p = PTR;
	while(p != NULL && !encontrado){
		if(p->data == x){
			encontrado = true;
		}
		p = p->next;
	}
	return encontrado;
}

void LinkedList::eliminar(int x){
	if(!vacia()){
		node *p = PTR;
		node *q = p;
		
		while(p != NULL){
			if(p->data == x){
				if(p == PTR){
					eliminarInicio();
				} else if (p->next == NULL){
					eliminarFinal();
				} else {
					q->next = p->next;
					p->next = NULL;
					delete p;
				}
				break;
			}
			q = p;
			p = p->next;
		}
	}
}

int LinkedList::obtener(int pos){
	int entero = -1;
	node *p = PTR;
	while(p != NULL){
		entero++;
		if(entero == pos){
			return p->data;
		}
		p = p->next;
	}
	return -1;
}

void LinkedList::insertarDespues(int x, int y){
	if(buscar(x)){
		node *p = PTR;
		while(p != NULL){
			if(p->data == x){
				node *nuevo = new node;
				nuevo->data = y;
				nuevo->next = p->next;
				p->next = nuevo;
				break;
			}
			p = p->next;
		}	
	}
}

void LinkedList::insertarAntes(int x, int y){
	if(buscar(x)){
		node *p = PTR;
		if(p->data == x){
			insertarInicio(y);
			return;
		}
		while(p != NULL){
			if(p->next->data == x){
				node *nuevo = new node;
				nuevo->data = y;
				nuevo->next = p->next;
				p->next = nuevo;
				break;
			}
			p = p->next;
		}		
	}
}

LinkedList concatenar(LinkedList l1, LinkedList l2){
	LinkedList l;
	int l1Cant = l1.cantidad();
	int l2Cant = l2.cantidad();
	
	for(int i=0; i<l1Cant; i++){
		l.insertarFinal(l1.obtener(i));
	}	
	
	for(int i=0; i<l2Cant; i++){
		l.insertarFinal(l2.obtener(i));
	}	
	
	return l;
}

LinkedList intersectar(LinkedList l1, LinkedList l2){
	LinkedList l;
	int l2Cant = l2.cantidad();
	
	for(int i=0; i<l2Cant; i++){
		if(l1.buscar(l2.obtener(i))){
			l.insertarFinal(l2.obtener(i));
		}
	}	
	return l;
}

int main(){
	LinkedList l;
	l.insertarFinal(2);
	l.insertarFinal(3);
	l.insertarFinal(4);
	l.insertarFinal(67);
	l.insertarInicio(10);
	l.insertarInicio(99);
	l.eliminar(3);
	l.insertarDespues(1, 5);
	l.insertarAntes(99, 1);
	l.mostrar();
	
	LinkedList nl;
	nl.insertarFinal(3);
	nl.insertarFinal(5);
	nl.insertarFinal(4);
	nl.insertarInicio(0);
	nl.insertarInicio(99);
	cout << "\n";
	nl.mostrar();
	cout << "\n\n";
	intersectar(l, nl).mostrar();
	
	return 1;
}
