package core

import "errors"

type node struct {
  value int
  priority int
  next *node
}

type PriorityQueue struct {
  data *node
}

func (p *PriorityQueue) Enqueue(priority int, value int) {
  newNode := new(node)
  newNode.priority = priority
  newNode.value = value

  if p.data == nil {
    p.data = newNode
  } else if priority > p.data.priority {
    newNode.next = p.data
    p.data = newNode
  } else {
    curr := p.data

    for curr.next != nil && priority <= curr.next.priority {
      curr = curr.next
    }

    newNode.next = curr.next
    curr.next = newNode
  }
}

func (p *PriorityQueue) Dequeue() (int, error) {
  if p.data == nil { return -1, errors.New("attempted to dequeue from empty priority queue") }

  retval := p.data.value
  p.data = p.data.next

  return retval, nil
}
