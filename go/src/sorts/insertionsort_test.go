package sorts

import "../testhelper"

import "testing"

func InsertionSortTest(t *testing.T) {
  arr := testhelper.RandomIntSlice(100)

  sorted := InsertionSort(arr)

  testhelper.TestIsSorted(sorted, t)
}
