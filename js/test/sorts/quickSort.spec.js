describe('Quick Sort', function() {
  it('should correctly sort an array', function() {
    var quickSort = new QuickSort();
    var arrayToSort = util.randomArray();

    // to safeguard against side-effects causing false positives
    expect(util.isSorted(arrayToSort)).toBe(false);

    var result = quickSort.sort(arrayToSort);

    expect(util.isSorted(result)).toBe(true);
  })
})
