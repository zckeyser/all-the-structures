describe('Selection Sort', function() {
  it('should correctly sort an array', function() {
    var selectionSort = new SelectionSort();
    var arrayToSort = util.randomArray();

    // to safeguard against side-effects causing false positives
    expect(util.isSorted(arrayToSort)).toBe(false);

    var result = selectionSort.sort(arrayToSort);

    expect(util.isSorted(result)).toBe(true);
  })
})
