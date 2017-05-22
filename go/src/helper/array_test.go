package helper

import "testing"

func TestIsSorted(t *testing.T) {
  sorted := []int{1, 2, 3}
  notSorted := []int{1, 3, 2}

  if !IsSorted(sorted) {
    t.Error("expected IsSorted(sorted) to be true")
  }

  if IsSorted(notSorted) {
    t.Error("expected IsSorted(unsorted) to be false")
  }
}
