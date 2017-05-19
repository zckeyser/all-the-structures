package testhelper

import "testing"

func TestAssertIsSorted(t *testing.T) {
  arr := []int{1, 2, 3}

  AssertIsSorted(arr, t)
}
