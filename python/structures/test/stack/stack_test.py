from pytest import fixture

import structures.src.stack.stack as stack_mod


@fixture(name='stack')
def init_stack():
    yield stack_mod.Stack()


def test_starts_empty(stack):
    assert len(stack) == 0


def test_single_item(stack):
    stack.push(10)

    assert len(stack) == 1

    result = stack.pop()

    assert result == 10
    assert len(stack) == 0


def test_multiple_items(stack):
    stack.push(10)
    stack.push(20)

    assert len(stack) == 2

    result = stack.pop()

    assert result == 20
    assert len(stack) == 1

    result = stack.pop()

    assert result == 10
    assert len(stack) == 0
