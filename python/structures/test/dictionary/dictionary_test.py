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

if __name__ == '__main__':
    unittest.main()
