pub fn get_primes(n: u32) -> Vec<u32> {
    let mut i = 0;
    let mut nums: Vec<u32> = (2..=n).collect();

    while i <= nums.len() - 1 {
        let mut j = i + 1;
        
        while j < nums.len() {
            let divisible = {
                let divisor = &nums[i];
                let numerator = &nums[j];
                numerator % divisor == 0
            };

            if divisible {
                nums.remove(j);
            } else {
                j += 1;
            }
        }
        i += 1;
    }

    nums
}