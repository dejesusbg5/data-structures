#include<iostream>
using namespace std;

struct Jugador{
	int cedula;
	string nombre;
	int goles;
	int edad;
	
	void toString(){
		cout << "\n " << cedula << " - " << nombre << " (" << edad << ") - " << goles << " goles";
	}
};

struct node{
	Jugador data;
	node *next;
	
	node(Jugador j){
		data = j;
		next = NULL;
	}
};

class CircularList {
	node *cursor = NULL;
	
	public:
		bool isEmpty(){
			return (cursor == NULL);
		}
		
		void push(Jugador j){
			node *nuevo = new node(j);
			
			if(isEmpty()) {
				cursor = nuevo;
			} else { 
				node *p = cursor;
				
				do {
					p = p->next;
				} while(p->next != cursor);
				
				p->next = nuevo;
			}
			
			nuevo->next = cursor;
		}
		
		void show(){
			if(!isEmpty()){
				node *p = cursor;
				
				do {
					p->data.toString();
					p = p->next;
				} while(p != cursor);
			}
		}
		
		void pop(int cedula){
			if(!isEmpty()){
				node *p = cursor;

				if(cursor->next == cursor && cursor->data.cedula == cedula){
					cursor = NULL;
					delete p;
				} else {
					node *q = p;
					do {
						if(p->data.cedula == cedula && p != cursor){							
							q->next = p->next;
							delete p;
							break;
						}
						
						q = p;
						p = p->next;
					} while (p != cursor);
					
					if(cursor->data.cedula == cedula){
						cursor = cursor->next;
						q->next = cursor;
						delete p;
					}						
				}
			}
		}

		bool search(int cedula){
			if(!isEmpty()){
				node *p = cursor;
				
				do {
					if(p->data.cedula == cedula){
						return true;
					}
					
					p = p->next;
				} while(p != cursor);
			}
			
			return false;
		}
		
		int length(){
			int len = 0;
			
			if(!isEmpty()){
				node *p = cursor;
								
				do {
					p = p->next;
					len++;
				} while(p != cursor);
			}
			
			return len;
		}
		
		Jugador get(int pos){			
			if(0 < pos && pos < length()){
				node *p = cursor;
				
				int i = 0;				
				do {
					if(pos == i){
						return p->data;
					}
					
					p = p->next;
					i++;
				} while(p != cursor);
			}
			
			Jugador j;
			j.cedula = -1;
			j.nombre = "N/A";
			j.goles = 0;
			return j;
		}
};

int main(){
	CircularList c;
	
	Jugador j;
	j.cedula = 112313;
	j.nombre = "Futbolista generico";
	j.edad = 19;
	j.goles = 24;
	c.push(j);
	
	j.cedula = 1463586;
	j.nombre = "Cristiano Ronaldo";
	j.edad = 37;
	j.goles = 809;
	c.push(j);
	
	j.cedula = 5876956;
	j.nombre = "Lionel Messi";
	j.edad = 34;
	j.goles = 765;
	c.push(j);
	
	c.show();
	c.get(-1).toString();
	
	return 1;
}
