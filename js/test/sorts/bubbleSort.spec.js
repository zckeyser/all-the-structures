describe("Bubble Sort", function() {
  it('Should correctly sort an array', function() {
    var bubbleSort = new BubbleSort();
    var arrayToSort = util.randomArray();

    // to safeguard against side-effects causing false positives
    expect(util.isSorted(arrayToSort)).toBe(false);

    bubbleSort.sort(arrayToSort);

    expect(util.isSorted(arrayToSort)).toBe(true);
  })
})
