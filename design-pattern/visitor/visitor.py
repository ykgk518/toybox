class VisitableList(list):
    def accept(self, visitor):
        visitor.visit_list(self)


class VisitableDict(dict):
    def accept(self, visitor):
        visitor.visit_dict(self)


class Printer(object):
    def visit_list(self, instance):
        print('リストの中身: {}'.format(instance))

    def visit_dict(self, instance):
        print('辞書の中身のキー: {}'.format(
            ', '.join(instance.keys())
        ))


class Visit():
    def __init__(self, visited, vistor):
        self.__cls = visited.__class__.__name__
        self.__method_name = 'visit_%s' % self.__cls
        self.__method = getattr(vistor, self.__method_name, None)

        self.__method(visited)
