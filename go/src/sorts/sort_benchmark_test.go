package sorts

import "../testhelper"

import "testing"

var size = 10000

func BenchmarkBubbleSort(b *testing.B) {
  for i := 0; i < b.N; i++ {
    arr := testhelper.RandomIntSlice(size)

    BubbleSort(arr)
  }
}

func BenchmarkInsertionSort(b *testing.B) {
  for i := 0; i < b.N; i++ {
    arr := testhelper.RandomIntSlice(size)

    InsertionSort(arr)
  }
}

func BenchmarkSelectionSort(b *testing.B) {
  for i := 0; i < b.N; i++ {
    arr := testhelper.RandomIntSlice(size)

    SelectionSort(arr)
  }
}

func BenchmarkMergeSort(b *testing.B) {
  for i := 0; i < b.N; i++ {
    arr := testhelper.RandomIntSlice(size)

    Mergesort(arr)
  }
}

func BenchmarkQuickSort(b *testing.B) {
  for i := 0; i < b.N; i++ {
    arr := testhelper.RandomIntSlice(size)

    Quicksort(arr)
  }
}

func BenchmarkRadixSort(b *testing.B) {
  for i := 0; i < b.N; i++ {
    arr := testhelper.RandomIntSlice(size)

    Quicksort(arr)
  }
}
