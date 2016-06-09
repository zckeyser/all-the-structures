describe('Array Search', function() {
  var search = new ArraySearch();
  var arr;

  describe('Linear Search', function() {
    beforeEach(function() {
      arr = [124, 550, 10, 761, 936, 441, 3, 87, 1038];
    })

    it('Should find an existing element', function() {
      expect(search.linear(arr, 10)).toBe(true);
    })

    it('Should not find a non-existing element', function() {
      expect(search.linear(arr, 100000)).toBe(false);
    })
  })

  describe('Binary Search', function() {
    beforeEach(function() {
      arr = [10, 30, 50, 70, 90, 110, 130, 150, 170, 190, 210];
    })

    it('Should find an existing element', function() {
      expect(search.binary(arr, 50)).toBe(true);
    })

    it('Should not find a non-existing element', function() {
      expect(search.binary(arr, 100)).toBe(false);
    })
  })
})
