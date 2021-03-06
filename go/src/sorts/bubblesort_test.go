package sorts

import "../testhelper"

import "testing"

func TestBubbleSort(t *testing.T) {
  arr := testhelper.RandomIntSlice(testhelper.ArraySize)

  sorted := BubbleSort(arr)

  testhelper.AssertIsSorted(sorted, t)
}
