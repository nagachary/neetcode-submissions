class NumArray:
    def __init__(self, nums: List[int]):
        self.my_list = nums[:]

    def sumRange(self, left: int, right: int) -> int:
        i = left
        sum = 0
        while i <= right:
            sum = sum + self.my_list[i]
            i+=1
        return sum

        


# Your NumArray object will be instantiated and called as such:
# obj = NumArray(nums)
# param_1 = obj.sumRange(left,right)