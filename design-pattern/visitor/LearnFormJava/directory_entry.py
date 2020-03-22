from entry import Entry
from typing import TypeVar, List

Visitor = TypeVar('Vistor')


class Directory():

    def __init__(self, name: str) -> None:
        self.__name = name
        self.__dir: List[Entry] = []

    def get_name(self) -> str:
        return self.__name

    def get_dir(self) -> List:
        return self.__dir

    def add(self, entry: Entry) -> Entry:
        self.__dir.append(entry)
        return self

    def accept(self, visitor: Visitor) -> None:
        visitor.visit_directory(self)
