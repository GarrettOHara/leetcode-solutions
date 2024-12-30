package main

import (
	"strings"
	"testing"
)

type TrieNode struct {
	isWord bool
	node   map[rune]*TrieNode
}

func NewTrie() *TrieNode {
	return &TrieNode{
		node: make(map[rune]*TrieNode),
	}
}

func (root *TrieNode) Insert(word string) {
	curr := root

	for _, ch := range word {
		if _, ok := curr.node[ch]; !ok {
			curr.node[ch] = NewTrie()
		}
		curr = curr.node[ch]
	}
	curr.isWord = true
}

func (root *TrieNode) Replace(word string) string {
	curr := root
	var str strings.Builder
	for _, ch := range word {
		if child, ok := curr.node[ch]; ok {
			str.WriteRune(ch)

			if child.isWord {
				return str.String()
			}

			curr = child

		} else {
			break
		}
	}

	return word
}

func replaceWords(dictionary []string, sentence string) string {
	trie := NewTrie()

	for _, word := range dictionary {
		trie.Insert(word)
	}

	words := strings.Split(sentence, " ")

	for i, word := range words {
		words[i] = trie.Replace(word)
	}

	var str strings.Builder
	for i, word := range words {
		str.WriteString(word)
		if i < len(words)-1 {
			str.WriteString(" ")
		}
	}

	return str.String()
}

func TestReplaceWords(t *testing.T) {

}
