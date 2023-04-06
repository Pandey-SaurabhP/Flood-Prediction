def readFromDB():
    f = open("/home/saurabhpandey/Desktop/FloodPrediction/Backend/repository/cities.txt", "r")
    return f.readlines()

def format(f):
    s = []

    for city in f:
        city = city.replace('\n', '')
        s.append(city)

    return s

    
class trieNode:

    def __init__(self, char):
        self.isTerminal = False
        self.char = char
        self.children = {}


class trie:

    def __init__(self):
        self.root = trieNode("")
        self.matchingCity = []


    def insert(self, cityName):
        
        start = self.root

        for char in cityName:
            if char in start.children:
                start = start.children[char]
            else:
                newNode = trieNode(char)
                start.children[char] = newNode
                start = newNode
        
        start.isTerminal = True 


    def dfs(self, root, pre):

        if root.isTerminal:
            self.matchingCity.append(pre + root.char)
        
        for child in root.children:
            self.dfs(child, pre + root.char)


    def query(self, cityName):
        start = self.root
        s = ""

        for char in cityName:
            if char in start.children:
                start = start.children[char]
                s += char
            else:
                break;

        self.dfs(start, s)



def fuzzySearch():

    f = readFromDB()
    cityNames = format(f)

    t = trie()
    for city in cityNames:
        t.insert(city)


    inputFromUser = str(input("Enter desired city : "))
    t.query(inputFromUser)


    return t.matchingCity

fuzzySearch()