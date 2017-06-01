package core

import "errors"

type Queue struct {
  data []interface{}
}

func (q *Queue) Enqueue(item interface{}) {
  q.data = append(q.data, item)
}

func (q *Queue) Dequeue() (interface{}, error) {
  if len(q.data) == 0 { return -1, errors.New("attempted to pop from empty stack") }

  retval := q.data[0]
  q.data = q.data[1:]

  return retval, nil
}

func (q *Queue) Size() int {
  return len(q.data)
}

func (q *Queue) Contains(item interface{}, equals func(interface{}, interface{}) bool) bool {
  for _, obj := range q.data {
    if equals(item, obj) {
      return true
    }
  }

  return false
}
