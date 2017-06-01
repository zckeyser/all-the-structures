package core

import "errors"

type Queue struct {
  data []int
}

func (q *Queue) Enqueue(item int) {
  q.data = append(q.data, item)
}

func (q *Queue) Dequeue() (int, error) {
  if len(q.data) == 0 { return -1, errors.New("attempted to pop from empty stack") }

  retval := q.data[0]
  q.data = q.data[1:]

  return retval, nil
}

func (q *Queue) Size() int {
  return len(q.data)
}
