describe('Insertion Sort', function() {
  it('should correctly sort an array', function() {
    var insertionSort = new InsertionSort();
    var arrayToSort = util.randomArray();

    // to safeguard against side-effects causing false positives
    expect(util.isSorted(arrayToSort)).toBe(false);

    var result = insertionSort.sort(arrayToSort);

    expect(util.isSorted(result)).toBe(true);
  })
})
