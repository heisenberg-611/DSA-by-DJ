#include <iostream> // Include necessary header for std::cout
#include <cstdlib>  // Include necessary header for std::malloc and std::exit
using namespace std;
struct Node {
    int data;
    Node* next;
}; // Missing semicolon added here

Node* create_node(int item, Node* next) {
    Node* new_node = (Node*)malloc(sizeof(Node)); // Cast malloc result to Node*
    if (new_node == nullptr) { // Use nullptr instead of NULL in modern C++
        cout << "Error! Could not create a new node.\n";
        exit(1); // Use std::exit instead of exit for consistency
    }

    new_node->data = item;
    new_node->next = next;

    return new_node;
}

int main() {
    Node* n;
    n = create_node(10, nullptr); // Use nullptr instead of NULL
    cout << "data = " << n->data << endl;

    free(n); // Free the allocated memory to prevent a memory leak
    return 0;
}
