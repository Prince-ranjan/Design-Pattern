import java.util.*;

public class Learning {
    public static void main(String[] args) {
        List<Integer> x = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()) {
            int y = scanner.nextInt();
            x.add(y);
        }

        int[] numbers = {3342,
                3342,
                5572,
                6919,
                6919,
                6944,
                7543,
                7990,
                8453,
                8610,
                8889,
                9381,
                10133,
                12637,
                12765,
                12766,
                12767,
                12768,
                13554,
                15105,
                15300,
                2840,
                3173,
                3174,
                9086,
                3343,
                3865,
                4021,
                4344,
        };


        x.stream().sorted();
        Arrays.sort(numbers);

        for(int i = 0; i < numbers.length; i++) {
            if(!x.contains(numbers[i])) {
                System.out.println("wrong value of " + numbers[i]);
            }
        }
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < n; i++) {
            int target = - nums[i];
            int front = i + 1, back = n -1;
            while(front < back) {
                if(nums[front] + nums[back] < target) {
                    front++;
                }
                else if(nums[front] + nums[back] > target) {
                    back--;
                }
                else{
                    List<Integer> currList = new ArrayList<>();
                    currList.add(nums[i]);
                    currList.add(nums[front]);
                    currList.add(nums[back]);
                    ans.add(currList);

                    while (front < back && nums[front] == currList.get(1)) front++;

                    while (front < back && nums[back] == currList.get(2)) back--;
                }
            }
        }
        return ans;
    }


    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            int front = i + 1;
            int back = n - 1;
            while(front < back) {
                int currSum = nums[i] + nums[front] + nums[back];
                if(Math.abs(currSum-target) < Math.abs(ans-target)) {
                    ans = currSum;
                }
                if(currSum > target) {
                    back--;
                }
                else if(currSum < target) {
                    front++;
                }
                else {
                    return target;
                }
            }
        }

        return ans;
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for(int i = 0; i < n - 3; i++) {
            if(i>0&&nums[i]==nums[i-1])continue;
            for(int j = i + 1; j < n - 2; j++) {
                if(j>i+1&&nums[j]==nums[j-1])continue;
                int twoSum = nums[i] + nums[j];
                int front = j + 1, back = n - 1;
                while(front < back) {
                    int nextTwoSum = nums[front] + nums[back];
                    if(nextTwoSum + twoSum < target) {
                        front++;
                    }
                    else if(nextTwoSum + twoSum > target) {
                        back--;
                    }
                    else {
                        List<Integer> currList = new ArrayList<>();
                        currList.add(nums[i]);
                        currList.add(nums[j]);
                        currList.add(nums[front]);
                        currList.add(nums[back]);
                        ans.add(currList);
                        while(front<back&&nums[front]==nums[front+1])front++;
                        while(front<back&&nums[back]==nums[back-1])back--;
                        front++;
                        back--;
                    }
                }
            }
        }
        return ans;
    }

    public static boolean canJump(int[] nums) {
        int size = nums.length;
        int maxEnd = 0;
        for(int i = 0; i < size; i++) {
            maxEnd = Math.max(maxEnd,nums[i] + i);
            if(maxEnd >= size - 1) {
                return  true;
            }
            if(i != 0 && nums[i] == 0 && maxEnd <= i) {
                return false;
            }
        }
        return false;
    }

    public static int jump(int[] nums) {
        int size = nums.length;
        int[] dp = new int[size];
        for(int i = 0; i < size; i++)
            dp[i] = Integer.MAX_VALUE;
        dp[0] = 0;
        for(int i = 0; i < size; i++) {
            int currStep = nums[i];
            for(int j = i + 1; j < size && j < i + currStep + 1; j++) {
                dp[j] = Math.min(dp[j],dp[i] + 1);
            }
        }
        for(int i = 0; i < size; i++) {
            System.out.println(dp[i]);
        }
        return dp[size-1];
    }

    static boolean helper(int[] arr, int start, boolean[] visited) {
        if(start < 0 || start >= arr.length) {
            return false;
        }
        if(visited[start]) {
            return false;
        }
        visited[start] =true;
        if(arr[start] == 0) {
            return true;
        }
        if(start == 0 || start == arr.length - 1) {
            return false;
        }
        int x = start + arr[start];
        int y = start - arr[start];
        return helper(arr,x,visited) || helper(arr,y,visited);
    }
    public static boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        return helper(arr,start,visited);
    }


    static int helper(int[] arr, int start, int destination, int steps, int startIdx, int previousIdx) {
        if(startIdx < 0 || startIdx >= arr.length)  {
            return Integer.MAX_VALUE;
        }
        if(start == destination && startIdx == arr.length - 1) {
            return steps;
        }
        else if(start == destination && startIdx != arr.length - 1) {
            return steps + 1;
        }
        int op1 = Integer.MAX_VALUE;
        int op2 = Integer.MAX_VALUE;
        int op3 = Integer.MAX_VALUE;
        if(startIdx - 1 >= 0 && startIdx - 1 != previousIdx) {
            op1 = helper(arr,arr[startIdx - 1],destination,steps + 1,startIdx - 1,startIdx);
        }
        if(startIdx + 1 < arr.length && startIdx + 1 != previousIdx) {
            op2 = helper(arr,arr[startIdx + 1],destination,steps + 1,startIdx + 1,startIdx);
        }
        for(int i = startIdx + 1; i < arr.length; i++) {
            if(arr[i] == start) {
                op3 = Math.min(helper(arr,arr[i],destination,steps + 1,i,startIdx),op3);
            }
        }
        return Math.min(op1,Math.min(op2,op3));
    }
    public static int minJumps(int[] arr) {
        int size = arr.length;
        int destination = arr[size - 1];
        int start = arr[0];
        return helper(arr,start,destination,0,0,0) == Integer.MAX_VALUE ? -1 : helper(arr,start,destination,0,0,0);
    }
    /*
    [100,-23,-23,404,100,23,23,23,3,404]

     */


}
