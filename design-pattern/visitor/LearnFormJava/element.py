from abc import ABCMeta, abstractmethod
from typing import TypeVar

Visitor = TypeVar('Visitor')


class Element(metaclass=ABCMeta):

    @abstractmethod
    def accept(self, vistor: Visitor) -> None:
        pass
