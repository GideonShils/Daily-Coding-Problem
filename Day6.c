/*
*  DAY 6:
* 
*  CURRENTLY DOESN'T EXECUTE PROPERLY BUT THE GENERAL IDEA IS SOUND
*  NEED TO FIX
*  
*  An XOR linked list is a more memory efficient doubly linked list. 
*  Instead of each node holding next and prev fields, it holds a field 
*  named both, which is a XOR of the next node and the previous node. 
*  Implement a XOR linked list; it has an add(element) which adds the 
*  element to the end, and a get(index) which returns the node at index.
*  
*  If using a language that has no pointers (such as Python), assume you 
*  have access to get_pointer and dereference_pointer functions that converts 
*  between nodes and memory addresses.
*/

#include <stdlib.h>
#include <stdio.h>

// Node has value, and pointer to next / prev node
typedef struct node {

	int val; // Value

	/* 
	*  Link is XOR of prev / next
	*  Head = XOR of 0 / next
	*  Tail = XOR of prev / 0
	*/
	struct node *link;
} node;

node* xor(node *first, node *second);
int add(int value);
node* get(int index);


int main() {
	printf("Starting");
	// Init
	node *head = malloc(sizeof(node));
	head->val = -1;
	head->link = 0;
	node *tail = head;

	printf("%p", (void *) head);

	// Add items
	for (int i = 0; i < 4; i++) {
		add(i, head, tail);
	}

	printf("Added");

	// Print items
	for (int i = 0; i < 4; i++) {
		printf("%d\n", get(i)->val);
	}
}

node* xor(node *first, node *second) {
	return (struct node*) ((unsigned int) (first) ^ (unsigned int) (second));
}

void add(int value, node *head, node *tail) {
	// Special case for adding first item
	if (head->val == -1) {
		head->val = value;
	}

	// Special case for adding second item
	else if (head == tail) {
		tail = malloc(sizeof(node));
		tail->val = value;
		tail->link = (struct node*) ((unsigned int) head ^ (unsigned int) NULL);
		head->link = (struct node*) ((unsigned int) NULL^ (unsigned int) tail);
	}

	// Standard case of adding to end
	else {
		node *newTail = malloc(sizeof(node));
		newTail->val = value;
		newTail->link = (struct node*) ((unsigned int) tail ^ (unsigned int) NULL);
		tail->link = (struct node*) (( unsigned int ) tail ^ (unsigned int) newTail);
		tail = newTail;
	}

	return 0;
}

node* get(int index) {
	node *currNode = head;
	node *nextNode = head->link;
	node *oldNode = NULL;
	while (nextNode != NULL) {
		oldNode = currNode;
		currNode = nextNode;
		nextNode = (struct node*) ((unsigned int) currNode->link ^ (unsigned int) oldNode);
	}

	return currNode;
}

/*
                     old       cur        nex = 0
		   old 		 cur 	   nex      
  1         2         3         4
0 ^ 2 <-> 1 ^ 3 <-> 2 ^ 4 <-> 3 ^ 0
*/