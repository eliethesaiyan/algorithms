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

    def find_duplicate(self, arr: list) -> list:

        #res = 0
        #arr_count = defaultdict(int)
        #for i, num in enumerate(arr):
        #    arr_count[num] +=1
        #for k, v in arr_count.items():
        #    if v > 1:
        #        return k
        duplicates =  set()
        arr.sort()
        for i in range(0, len(arr)-1):
            if arr[i] - arr[i+1] == 0:
                duplicates.add(arr[i])


        return duplicates 
    
    def reverse_array(self, arr: list) -> list:
        swap = 0
        for i in range(0, len(arr)//2):
            swap = arr[i]
            arr[i] = arr[len(arr)-1 -i]
            arr[len(arr) -1 - i] = swap
        #swap = None
        del swap
        
        return arr
    
    def two_body_sum_two_loop(self, arr: list, sum: int) -> int:
        count = 0
        for i in range(0, len(arr) - 1):
            for j in range(i+1, len(arr)):
                if arr[i] + arr[j] == sum:
                    print(arr[i], arr[j])
                    count += 1
        return count
    
    def three_body_sum_three_loop(self, arr: list, sum: int) -> int:
        count = 0

        for i in range(0, len(arr) - 2):
            for j in range(i+1, len(arr) -1):
                for k in range(j+1, len(arr)):
                    if arr[i] + arr[j] + arr[k] == sum:
                        print(arr[i], arr[j], arr[k])
                        count += 1
        return count

    def three_body_sum_two_loop(self, arr: list, sum: int) -> int:
        count = 0
        for i in range(0, len(arr)-2):
            for j in range(i+1, len(arr)- 1):
                if (sum - (arr[i]+ arr[j]) - arr[j+1]) == 0:
                    print("sum", sum, ",i", arr[i], ", j", arr[j], ", j+1", arr[j+1])
                    count +=1 
        return count

    def binary_search(self, arr: list, key: int) -> int:
        low_idx = 0 
        high_idx = len(arr) - 1

        while(low_idx <= high_idx):
            mid = low_idx +  (high_idx - low_idx) // 2
            if arr[mid] < key:
                low_idx = mid + 1
            elif arr[mid] > key:
                high_idx = mid - 1
            else:
                return mid, arr[mid]
        return -1

            




if __name__ == "__main__":
   # array_of_integers  = [1, 2, 3,4,3,3,2,2]
    array_of_integers =[ 1, 2, 4, 6, 3, 7, 8]

    m_number = MissingNumber(array_of_integers)
    #print(m_number.find_missing_number())
    #print(m_number.find_duplicate(array_of_integers))
    #print(m_number.reverse_array(array_of_integers))
    #print(m_number.two_body_sum_two_loop(array_of_integers, 5))
    #print(m_number.three_body_sum_three_loop(array_of_integers, 10))
    #print(m_number.three_body_sum_two_loop(array_of_integers, 12))
    print(m_number.binary_search(array_of_integers, 6))