from collections import defaultdict
class MissingNumber:
    def __init__(self, number_list: list):
        self.number_list = number_list
    
    def find_missing_number(self)-> int:
        
        missing_number = -1 # double for loop
        for i in range(0, len(self.number_list)-1):
            update_missing_number = True
            for j in range(1, len(self.number_list)):
                if self.number_list[j] - self.number_list[i] -1  == 0:
                    print(i,"found")
                    update_missing_number = False
            if (update_missing_number):
                missing_number = self.number_list[i] + 1
        return missing_number  
    def find_duplicate(self, arr: list) -> int:
        res = 0
        arr_count = defaultdict(int)
        for i, num in enumerate(arr):
            arr_count[num] +=1
        for k, v in arr_count.items():
            if v > 1:
                return k
        



if __name__ == "__main__":
    array_of_integers  = [1, 2, 3, 5]
   # array_of_integers =[ 1, 2, 4, 6, 3, 7, 8]

    m_number = MissingNumber(array_of_integers)
    #print(m_number.find_missing_number())
    print(m_number.find_duplicate(array_of_integers))