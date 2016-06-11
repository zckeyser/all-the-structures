describe('Linked List', function() {
    var list;

    describe('length', function() {
        beforeEach(function() {
            list = new LinkedList(5);

            list.add(10);
            list.add(15);
            list.add(20);
            list.add(25);
        })

        it('should return correct length', function() {
            expect(list.length()).toBe(5);
        })
    })

    describe('get', function() {
        beforeEach(function() {
            list = new LinkedList(5);

            list.add(10);
            list.add(15);
            list.add(20);
            list.add(25);
        })

        it('should correctly get a value from the front of the list', function() {
            expect(list.get(0)).toBe(5);
        })

        it('should correctly get a value from the middle of the list', function() {
            expect(list.get(2)).toBe(15);
        })

        it('should correctly get a value from the end of the list', function() {
            expect(list.get(4)).toBe(25);
        })

        it('should return null when called on an out-of-bound index', function() {
            expect(list.get(6)).toBeNull();
        })
    })

    describe('set', function() {
        beforeEach(function() {
            list = new LinkedList(5);

            list.add(10);
            list.add(15);
            list.add(20);
            list.add(25);
        })

        it('should correctly modify the value at the front of the list', function() {
            list.set(0, 100);
            expect(list.get(0)).toEqual(100);
        });

        it('should correctly modify the value in the middle of the list', function() {
            list.set(2, 100);
            expect(list.get(2)).toEqual(100);
        });

        it('should correctly modify the value at the end of the list', function() {
            list.set(4, 100);
            expect(list.get(4)).toEqual(100);
        });
    })

    describe('remove', function() {
        beforeEach(function() {
            list = new LinkedList(5);

            list.add(10);
            list.add(15);
            list.add(20);
            list.add(25);
        })

        it('should correctly remove list elements from the given index', function() {
            expect(list.length()).toBe(5);
            expect(list.get(2)).toBe(15);

            list.remove(2);

            expect(list.length()).toBe(4);
            expect(list.get(2)).toBe(20);
        })
    })

    describe('contains', function() {
        beforeEach(function() {
            list = new LinkedList(5);

            list.add(10);
            list.add(15);
            list.add(20);
            list.add(25);
        })

        it('should correctly find a contained element', function() {
            expect(list.contains(15)).toBe(true);
        })

        it('should not find an uncontained element', function() {
            expect(list.contains(100)).toBe(false);
        })

        it('should use strict equality by default', function() {
            list.add('30');

            expect(list.contains(30)).toBe(false);
        })

        it('should use a comparator if one is given', function() {
            list.add('30');

            var result = list.contains(30, function(a, b) {
                return a == b;
            })

            expect(result).toEqual(true);
        })
    })

    describe('indexOf', function() {
        beforeEach(function() {
            list = new LinkedList(5);

            list.add(10);
            list.add(15);
            list.add(20);
            list.add(25);
        })

        it('should correctly find the index of the first list element', function() {
            expect(list.indexOf(5)).toBe(0);
        })

        it('should correctly find the index of a middle list element', function() {
            expect(list.indexOf(15)).toBe(2);
        })

        it('should correctly find the index of an end list element', function() {
            expect(list.indexOf(25)).toBe(4);
        })

        it('should not find the index of a value not in the list', function() {
            expect(list.indexOf(100)).toBe(-1);
        })

        it('should use strict equality by default', function() {
            list.add('30');

            expect(list.contains(30)).toBe(false);
        })

        it('should use a comparator if one is given', function() {
            list.add('30');

            var result = list.contains(30, function(a, b) {
                return a == b;
            })

            expect(result).toEqual(true);
        })
    })
})
