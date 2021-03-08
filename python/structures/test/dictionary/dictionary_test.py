import structures.src.dictionary.dictionary as mydict


def test_insert():
    dictionary = mydict.Dictionary()

    dictionary['foo'] = 'bar'

    assert dictionary['foo'] == 'bar'


def test_update():
    dictionary = mydict.Dictionary()

    dictionary['foo'] = 'bar'
    dictionary['foo'] = 'buzz'

    assert dictionary['foo'] == 'buzz'
    assert len(dictionary) == 1


def test_contains_key():
    dictionary = mydict.Dictionary()

    dictionary['foo'] = 'bar'

    assert dictionary.contains_key('foo')
    assert not dictionary.contains_key('bar')


def test_size():
    dictionary = mydict.Dictionary()

    assert len(dictionary) == 0

    dictionary['foo'] = 'bar'

    assert len(dictionary) == 1

    dictionary['fizz'] = 'buzz'

    assert len(dictionary) == 2

    dictionary.remove('fizz')

    assert len(dictionary) == 1


def test_remove():
    dictionary = mydict.Dictionary()

    dictionary['foo'] = 'bar'

    dictionary.remove('foo')

    assert not dictionary.contains_key('foo')


def test_expand():
    dictionary = mydict.Dictionary()

    inserted = []

    for i in range(0, 5000):
        key = 'a' * i
        value = i

        dictionary[key] = value

        inserted.append((key, value))

    for key, value in inserted:
        assert dictionary[key] == value

    assert len(dictionary) == 5000
