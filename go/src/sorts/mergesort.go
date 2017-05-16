package sorts

// mergesort
func Mergesort(arr []int) ([]int) {
  if len(arr) <= 1 {
    return arr
  }

  mid := len(arr) / 2

  left := Mergesort(arr[:mid])
  right := Mergesort(arr[mid:])

  return merge(left, right)
}

func merge(a []int, b []int) (sorted []int) {
  sorted = nil

  i, j := 0, 0

  for i < len(a) && j < len(b) {
    if a[i] < b[j] {
      sorted = append(sorted, a[i])
      i++
    } else {
      sorted = append(sorted, b[j])
      j++
    }
  }

  for i < len(a) {
    sorted = append(sorted, a[i])
    i++
  }

  for j < len(b) {
    sorted = append(sorted, b[j])
    j++
  }

  return
}
