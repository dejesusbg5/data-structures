#include<iostream>
#include <cstdlib>
#include <ctime>
using namespace std;

void llenarMatriz(int matrix[][100], int m, int n, int i, int j){
	if (i<m){		
		matrix[i][j] = rand() % 100;
		
		if (j<n-1){
			llenarMatriz(matrix, m, n, i, j+1);
		} else {
			llenarMatriz(matrix, m, n, i+1, 0);
		}
	}
}

void mostrarMatriz(int matrix[][100], int m, int n, int i, int j){
	if (i<m){		
		cout << " " << matrix[i][j] << ",";
		
		if (j<n-1){
			mostrarMatriz(matrix, m, n, i, j+1);
		} else {
			cout << endl;
			mostrarMatriz(matrix, m, n, i+1, 0);
		}
	}
}

void mostrarDiagonalPrincipal(int matrix[][100], int m, int n, int i){
	if (i<m){		
		cout << " " << matrix[m-i-1][i] << ",";
		mostrarDiagonalPrincipal(matrix, m, n, i+1);
	}
}

int main(){
	srand(time(0));
	
	int mat[100][100], n1, n2;
	cout << " Digite cantidad de filas: ";
	cin >> n1;
	cout << " Digite cantidad de columnas: ";
	cin >> n2;
	 
	llenarMatriz(mat, n1, n2, 0, 0);
	mostrarMatriz(mat, n1, n2, 0, 0);
	
	cout << endl;
	mostrarDiagonalPrincipal(mat, n1, n2, 0);

	return 1;
}
