import unittest

import structures.src.dictionary.dictionary as mydict

class TestDictionary(unittest.TestCase):
    def test_insert(self):
        dictionary = mydict.Dictionary()

        dictionary['foo'] = 'bar'

        self.assertEquals(dictionary['foo'], 'bar')

    def test_update(self):
        dictionary = mydict.Dictionary()

        dictionary['foo'] = 'bar'
        dictionary['foo'] = 'buzz'

        self.assertEquals(dictionary['foo'], 'buzz')
        self.assertEquals(len(dictionary), 1)

    def test_containskey(self):
        dictionary = mydict.Dictionary()

        dictionary['foo'] = 'bar'

        self.assertTrue(dictionary.contains_key('foo'))
        self.assertFalse(dictionary.contains_key('bar'))

    def test_size(self):
        dictionary = mydict.Dictionary()

        self.assertEquals(len(dictionary), 0)

        dictionary['foo'] = 'bar'

        self.assertEquals(len(dictionary), 1)

        dictionary['fizz'] = 'buzz'

        self.assertEquals(len(dictionary), 2)

        dictionary.remove('fizz')

        self.assertEquals(len(dictionary), 1)

    def test_remove(self):
        dictionary = mydict.Dictionary()

        dictionary['foo'] = 'bar'

        dictionary.remove('foo')

        self.assertFalse(dictionary.contains_key('foo'))

    def test_expand(self):
        dictionary = mydict.Dictionary()

        inserted = []

        for i in range(0, 5000):
            key = 'a' * i
            value = i

            dictionary[key] = value

            inserted.append((key, value))

        for pair in inserted:
            self.assertEquals(dictionary[pair[0]], pair[1])

        self.assertEquals(len(dictionary), 5000)

if __name__ == '__main__':
    unittest.main()
