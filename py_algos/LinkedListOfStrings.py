class Node:
    def __init__(self, item: str)->None:
        self.item = item
        self.next = None
    

class LinkedListOfStrings:
    def __init__(self)-> None:
        self.first = None
    
    def isEmpty(self)-> None:
        return self.first == None

    def push(self, data: str)->None:
        old_first = self.first
        self.first = Node(data)
        self.first.next = old_first
    
    def pop(self) -> str:
        data = self.first.item
        self.first  = self.first.next
        return data

    def print_all(self)-> None:
        print(self.first.item)
        while(self.first!=None):
            print(self.first.item)
            self.first = self.first.next


if __name__  == "__main__":

    array_of_integers =[ "1", "2", "4","6", "3", "7", "8"]
    lkd = LinkedListOfStrings()
    for i in range(0, len(array_of_integers)):
        lkd.push(array_of_integers[i])
    lkd.print_all()




       