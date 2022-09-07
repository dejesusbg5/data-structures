#include<iostream>
using namespace std;

void llenarVector(int v[], int n, int i){
	if (i<n){
		v[i] = i+1;
		
		llenarVector(v, n, i+1);
	}
}

void mostrarVector(int v[], int n, int i){
	if (i<n){
		cout << " " << v[i] << ",";
		mostrarVector(v, n, i+1);
	}
}

void mostrarVectorInverso(int v[], int n, int i){
	if (i<n){
		mostrarVectorInverso(v, n, i+1);
		cout << " " << v[i] << ",";
	}
}

int sumarVector(int v[], int n, int i){
	return (i<n) ? v[i] + sumarVector(v, n, i+1) : 0;
}

int contarVector(int v[], int n, int i, int x){
	if (i<n){
		return ((v[i] == x) ? 1 : 0) + contarVector(v, n, i+1, x);
	}
	
	return 0;
}

bool buscarEnVector(int v[], int n, int i, int x){
	if (i<n){
		return ((v[i] == x) ? true : false) || buscarEnVector(v, n, i+1, x);
	}
	
	return false;
}

int main(){
	int n;
	cout << " Digite cantidad de datos: ";
	cin >> n;
	 
	int v[n];
	llenarVector(v, n, 0);
	
	cout << endl << " Vector inverso:";
	mostrarVectorInverso(v, n, 0);
	
	cout << endl << " Suma: " << sumarVector(v, n, 0);
	
	cout << endl << " 5 fue encontrado " << contarVector(v, n, 0, 5) << " veces";
	
	cout << endl << " 6 fue encontrado? " << buscarEnVector(v, n, 0, 6);
	return 1;
}
