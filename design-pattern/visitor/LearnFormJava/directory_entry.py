from entry import Entry
from typing import TypeVar, List
from visit import Visitor


class Directory():

    def __init__(self, name: str, dir) -> None:
        self.__name = name
        self.__dir: List[Entry] = []

    def get_name(self) -> str:
        return self.__name

    def get_size(self) -> int:
        size = 0
        it = iter(self.__dir)
        try:
            while(it.__next__()):
                entry = Entry(it.__next__())
                size += entry.get_size()
        except StopIteration:
            pass
        return size

    def add(self, entry: Entry) -> Entry:
        self.__dir.append(entry)
        return self

    def iterator(self) -> iterator:
        return iter(self.__dir)

    def accept(self, visitor: Visitor) -> None:
        visitor.visit_directory(self)
