from __future__ import absolute_import
from __future__ import print_function
from satispy import Variable, Cnf
from satispy.solver import Minisat

solver = Minisat()

puzzles = []
f = open("generator-output.txt", "r")
f.readline()
for l in f:
  puzzles.append(l)

puzzles[0] = puzzles[0][1:len(puzzles[0])-2]
test = puzzles[0].split(',')

varDict = {'1':[Variable('1'), False], '2':[Variable('2'), False],'3':[Variable('3'), False],'4':[Variable('4'), False],'5':[Variable('5'), False],
'6':[Variable('6'), False],'7':[Variable('7'), False],'8':[Variable('8'), False], '9':[Variable('9'), True], '10':[Variable('10'), True], '11':[Variable('11'), True],
'12':[Variable('12'), True], '13':[Variable('13'), False], '14':[Variable('14'), False],'15':[Variable('15'), False],'16':[Variable('16'), False],'17':[Variable('17'), False],
'18':[Variable('18'), False],'19':[Variable('19'), False],'20':[Variable('20'), False], '21':[Variable('21'), True], '22':[Variable('22'), True], '23':[Variable('23'), True],
'24':[Variable('24'), True], '25':[Variable('25'), True], '26':[Variable('26'), True], '27':[Variable('27'), True], '28':[Variable('28'), True], '29':[Variable('29'), True],
'30':[Variable('30'), True], '31':[Variable('31'), True], '32':[Variable('32'), True], '33':[Variable('33'), True], '34':[Variable('34'), True], '35':[Variable('35'), True],
'36':[Variable('36'), True], '37':[Variable('37'), False], '38':[Variable('38'), True], '39':[Variable('39'), True], '40':[Variable('40'), False], '41':[Variable('41'), False],
'42':[Variable('42'), True], '43':[Variable('43'), True], '44':[Variable('44'), False], '45':[Variable('45'), True], '46':[Variable('46'), True], '47':[Variable('47'), True],
'48':[Variable('48'), True],  '49':[Variable('49'), False], '50':[Variable('50'), False],
        '51':[Variable('51'), False],'52':[Variable('52'), False],
        '53':[Variable('53'), False],'54':[Variable('54'), False],
        '55':[Variable('55'), False],'56':[Variable('56'), False],
        '57':[Variable('57'), False],'58':[Variable('58'), False],
        '59':[Variable('59'), True],'60':[Variable('60'), True],
        '61':[Variable('61'), False], '62':[Variable('62'), False],
        '63':[Variable('63'), False],'64':[Variable('64'), False],
        '65':[Variable('65'), False],'66':[Variable('66'), False],
        '67':[Variable('67'), False],'68':[Variable('68'), False],
        '69':[Variable('69'), False],'70':[Variable('70'), False],
        '71':[Variable('71'), True],'72':[Variable('72'), True]}

for pos in puzzles:
    pos = pos.split(',')

    exp = Cnf()

    for i in range(len(varDict)):
        if varDict[str(i+1)][1] == False:
            exp &= -varDict[str(i+1)][0]
        else:
            exp &= varDict[str(i+1)][0]       

    for i in range(0, len(pos), 2):
        tmp1 = pos[i].split('=')
        tmp2 = pos[i+1].split('=')
        if tmp1[1] == 'false':
            if tmp2[1] == 'false':
                exp &= -varDict[tmp1[0][1:]][0] ^ -varDict[tmp2[0][1:]][0]
            else:
                exp &= -varDict[tmp1[0][1:]][0] ^ varDict[tmp2[0][1:]][0] 
        else:
            if tmp2[1] == 'false':
                exp &= varDict[tmp1[0][1:]][0] ^ -varDict[tmp2[0][1:]][0] 
            else:
                exp &= varDict[tmp1[0][1:]][0] ^ varDict[tmp2[0][1:]][0] 

    solution = solver.solve(exp)

    if solution.success:
        print('success')
        break
    else:
        print('fail')











 



  









