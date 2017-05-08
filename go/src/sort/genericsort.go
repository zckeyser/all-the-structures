package mysort

// sort for arbitrary types
type Comparable interface {
  Less(other interface{}) bool
}

// mergesort
func Sort(arr []Comparable) ([]Comparable) {
  if len(arr) <= 1 {
    return arr
  }

  mid := len(arr) / 2

  left := Sort(arr[:mid])
  right := Sort(arr[mid:])

  return merge(left, right)
}

func merge(a []Comparable, b []Comparable) (sorted []Comparable) {
  sorted = nil

  i, j := 0, 0

  for i < len(a) && j < len(b) {
    if a[i].Less(b[j]) {
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
