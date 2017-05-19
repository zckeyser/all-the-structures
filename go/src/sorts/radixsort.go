package sorts

func RadixSort(arr []int) []int {
  // Base 10 is used
	largestNum := findLargestNum(arr)
	size := len(arr)
	significantDigit := 1
	semiSorted := make([]int, size, size)

	// Loop until we reach the largest significant digit
	for largestNum / significantDigit > 0 {
		bucket := [10]int{0}

		// Counts the number of "keys" or digits that will go into each bucket
		for i := 0; i < size; i++ {
      digit := (arr[i] / significantDigit) % 10
			bucket[digit]++
		}

		// Add the count of the previous buckets
    // Acquires the indices after the end of each bucket location in the array
		for i := 1; i < 10; i++ {
			bucket[i] += bucket[i - 1]
		}

		// Use the bucket to fill a "semiSorted" array
		for i := size - 1; i >= 0; i-- {
      digit := (arr[i] / significantDigit) % 10
			bucket[digit]--
			semiSorted[bucket[digit]] = arr[i]
		}

    // Replace the current arr with the semisorted arr
		for i := 0; i < size; i++ {
			arr[i] = semiSorted[i]
		}

    // Move to next significant digit
		significantDigit *= 10
	}

	return arr
}

// Finds the largest number in an array
func findLargestNum(arr []int) int {
	largestNum := 0

	for i := 0; i < len(arr); i++ {
		if arr[i] > largestNum {
			largestNum = arr[i]
		}
	}
	return largestNum
}
