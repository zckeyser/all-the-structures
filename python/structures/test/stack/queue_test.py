from pytest import fixture

import structures.src.stack.queue as queue_mod


# @fixture('queue')
# def init_queue():
#     yield queue_mod.Queue()


# def test_starts_empty(queue):
#     assert len(queue) == 0


# def test_single_item(queue):
#     queue.push(10)

#     assert len(queue) == 1

#     result = queue.pop()

#     assert result == 10
#     assert len(queue) == 0


# def test_multiple_items(queue):
#     queue.push(10)
#     queue.push(20)

#     assert len(queue) == 2

#     result = queue.pop()

#     assert result == 10
#     assert len(queue) == 1

#     result = queue.pop()

#     assert result == 20
#     assert len(queue) == 0
