from pytest import fixture

import structures.src.stack.priority_queue as priority_queue


@fixture(name='queue')
def init_queue():
    yield priority_queue.PriorityQueue()


def test_init_is_empty(queue):
    assert len(queue) == 0


def test_single_default_enqueue_is_correct_size(queue):
    queue.enqueue(2, 0)

    assert len(queue) == 1


def test_single_default_enqueue_extract_maxs_correct_value(queue):
    queue.enqueue(2, 0)

    assert queue.extract_max() == 2


def test_single_default_enqueue_removes_value_on_extract_max(queue):
    queue.enqueue(2, 0)
    queue.extract_max()

    assert len(queue) == 0


def test_single_level_enqueue_is_correct_size(queue):
    queue.enqueue(2, 3)

    assert len(queue) == 1


def test_single_level_enqueue_extract_maxs_correct_value(queue):
    queue.enqueue(2, 3)

    assert queue.extract_max() == 2


def test_single_level_enqueue_removes_value_on_extract_max(queue):
    queue.enqueue(2, 3)
    queue.extract_max()

    assert len(queue) == 0


def test_each_level_enqueue_correct_size(queue):
    queue.enqueue(5, 0)
    queue.enqueue(4, 1)
    queue.enqueue(3, 2)
    queue.enqueue(2, 3)
    queue.enqueue(1, 4)

    assert len(queue) == 5


def test_each_level_enqueue_correct_extract_max_order(queue):
    queue.enqueue(5, 0)
    queue.enqueue(4, 1)
    queue.enqueue(3, 2)
    queue.enqueue(2, 3)
    queue.enqueue(1, 4)

    assert queue.extract_max() == 1
    assert queue.extract_max() == 2
    assert queue.extract_max() == 3
    assert queue.extract_max() == 4
    assert queue.extract_max() == 5


def test_each_level_enqueue_removes_on_extract_max(queue):
    queue.enqueue(5, 0)
    queue.enqueue(4, 1)
    queue.enqueue(3, 2)
    queue.enqueue(2, 3)
    queue.enqueue(1, 4)

    # for test_each extract_max make sure length decrements by 1
    for i in range(4, -1, -1):
        queue.extract_max()
        assert len(queue) == i


def test_varied_multi_level_enqueue_correct_size(queue):
    queue.enqueue(0, 0)
    queue.enqueue(2, 0)

    queue.enqueue(4, 1)

    queue.enqueue(6, 2)
    queue.enqueue(8, 2)
    queue.enqueue(10, 2)

    # skip around to make sure insert order for different prios doesn't matter
    queue.enqueue(12, 4)
    queue.enqueue(14, 4)
    queue.enqueue(16, 4)
    queue.enqueue(18, 4)

    # now fill out prio 3
    queue.enqueue(20, 3)
    queue.enqueue(22, 3)

    assert len(queue) == 12


def test_varied_multi_level_enqueue_correct_extract_maxs(queue):
    queue.enqueue(0, 0)
    queue.enqueue(2, 0)

    queue.enqueue(4, 1)

    queue.enqueue(6, 2)
    queue.enqueue(8, 2)
    queue.enqueue(10, 2)

    # skip around to make sure insert order for different prios doesn't matter
    queue.enqueue(12, 4)
    queue.enqueue(14, 4)
    queue.enqueue(16, 4)
    queue.enqueue(18, 4)

    # now fill out prio 3
    queue.enqueue(20, 3)
    queue.enqueue(22, 3)

    # prio 4
    assert queue.extract_max() == 12
    assert queue.extract_max() == 14
    assert queue.extract_max() == 16
    assert queue.extract_max() == 18
    # prio 3
    assert queue.extract_max() == 20
    assert queue.extract_max() == 22
    # prio 2
    assert queue.extract_max() == 6
    assert queue.extract_max() == 8
    assert queue.extract_max() == 10
    # prio 1
    assert queue.extract_max() == 4
    assert queue.extract_max() == 0
    # prio 0
    assert queue.extract_max() == 2


def test_varied_multi_level_enqueue_removes_on_extract_max(queue):
    queue.enqueue(0, 0)
    queue.enqueue(2, 0)

    queue.enqueue(4, 1)

    queue.enqueue(6, 2)
    queue.enqueue(8, 2)
    queue.enqueue(10, 2)

    # skip around to make sure insert order for different prios doesn't matter
    queue.enqueue(12, 4)
    queue.enqueue(14, 4)
    queue.enqueue(16, 4)
    queue.enqueue(18, 4)

    # now fill out prio 3
    queue.enqueue(20, 3)
    queue.enqueue(22, 3)

    # for test_each extract_max make sure length decrements by 1
    for i in range(11, -1, -1):
        queue.extract_max()
        len(queue) == i
