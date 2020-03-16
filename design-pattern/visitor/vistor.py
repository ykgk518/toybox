class VistitableList(list):
    def accept(self, visitor):
        visitor.visit_list(self)

class VistitableDict(dict):
    def accept(self, visitor):
        visitor.visit_dict(self)

class Printer(object):
    def visit_list(self, instance):
        print('リストの中身: {}'.format(instance))

    def visit_dict(self, instance):
        print('辞書の中身のキー: {}'.format(
            ', '.join(instance.keys()) 
        ))
