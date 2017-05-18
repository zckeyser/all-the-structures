package sorts

import "../testhelper"

import "testing"

func TestBubbleSort(t *testing.T) {
  arr := testhelper.RandomIntSlice(100)

  sorted := BubbleSort(arr)

  testhelper.TestIsSorted(sorted, t)
}
