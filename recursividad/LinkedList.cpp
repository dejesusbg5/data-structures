#include <iostream>
using namespace std;

struct node {
  int data;
  node *next;

  node(int x) {
    data = x;
    next = NULL;
  }
};

class LinkedList {
  node *PTR = NULL;

  void __print__(node *p) {
    if (p != NULL) {
      cout << " " << p->data;
      __print__(p->next);
    }
  }

  void __reversePrint__(node *p) {
    if (p != NULL) {
      __reversePrint__(p->next);
      cout << " " << p->data;
    }
  }

public:
  int length = 0;

  bool isEmpty() { return (PTR == NULL); };

  void print() {
    if (!isEmpty()) {
      __print__(PTR);
    }
  };

  void reversePrint() {
    if (!isEmpty()) {
      __reversePrint__(PTR);
    }
  };

  void append(int x) {
    node *nuevo = new node(x);
    node *p = PTR;

    if (isEmpty()) {
      PTR = nuevo;
    } else {
      while (p->next != NULL) {
        p = p->next;
      }
      p->next = nuevo;
    }

    length++;
  };

  void prepend(int x) {
    if (isEmpty()) {
      append(x);
    } else {
      node *nuevo = new node(x);
      nuevo->next = PTR;
      PTR = nuevo;
    }

    length++;
  };

  void unappend() {
    if (!isEmpty()) {
      node *p = PTR;
      node *q = p;

      if (PTR->next == NULL) {
        PTR = NULL;
      } else {
        while (p->next != NULL) {
          q = p;
          p = p->next;
        }
        q->next = NULL;
      }

      delete p;
      length--;
    }
  };

  void unprepend() {
    if (!isEmpty()) {
      node *p = PTR;
      PTR = PTR->next;
      p->next = NULL;

      delete p;
      length--;
    }
  };

  int at(int pos) {
    if (pos <= length) {
      node *p = PTR;

      int i = 0;
      while (p != NULL) {
        if (i == pos) {
          return p->data;
        }

        p = p->next;
        i++;
      }

      return -1;
    }
  };

  bool find(int x) {
    if (!isEmpty()) {
      node *p = PTR;

      while (p != NULL) {
        if (p->data == x) {
          return true;
        }
        p = p->next;
      }
    }

    return false;
  };

  void filter(int x) {
    if (!isEmpty()) {
      node *p = PTR;
      node *q = p;

      while (p != NULL) {
        if (p->data == x) {
          if (p == PTR) {
            unprepend();
          } else if (p->next == NULL) {
            unappend();
          } else {
            q->next = p->next;
            p->next = NULL;
            delete p;
            length--;
          }
          break;
        }
        q = p;
        p = p->next;
      }
    }
  };
};

int main() {
  LinkedList l;
  l.append(1);
  l.append(2);
  l.append(4);
  l.append(8);
  l.append(16);
  l.prepend(0);

  l.reversePrint();

  return 1;
}