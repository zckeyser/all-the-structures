package core

import "errors"

type Stack struct {
  data []interface{}
}

func (s *Stack) Push(item interface{}) {
  s.data = append([]interface{}{item}, s.data...)
}

func (s *Stack) Pop() (interface{}, error) {
  if len(s.data) == 0 { return -1, errors.New("attempted to pop from empty stack") }

  retval := s.data[0]
  s.data = s.data[1:]

  return retval, nil
}

func (s *Stack) Size() int {
  return len(s.data)
}

func (s *Stack) Contains(item interface{}, equals func(interface{}, interface{}) bool) bool {
  for _, obj := range s.data {
    if equals(item, obj) {
      return true
    }
  }

  return false
}
