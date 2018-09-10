import numpy as np
import matplotlib.pyplot as plt
from scipy import interpolate
from math import log

plt.figure(figsize=(10, 7))

inputs = [50000 , 100000 , 200000 , 400000 , 800000 , 3200000 ]
#, 6400000 , 12800000 , 25600000 , 1024000000 , 2048000000]

def plot_algo_complexity(name,  g1 , g2 , g3 , g4 , g5):
	plt.title(name)
	plt.axis([min(inputs), max(inputs), min( g1 + g2 + g3 + g4 + g5), 10000])
	#max(g1 + g2 + g3 + g4 + g5)
	
	#interpolate functions for the three array inputs
	g1_function = interpolate.interp1d(inputs, g1)
	g2_function = interpolate.interp1d(inputs, g2)
	g3_function = interpolate.interp1d(inputs, g3)
	g4_function = interpolate.interp1d(inputs, g4)
	g5_function = interpolate.interp1d(inputs, g5)


	#plot inputs arrays alog with threir interploation functions
	g1_line, g1_curve = plt.plot(inputs, g1, 'go', inputs, g1_function(inputs), 'g-')
	g2_line, g2_curve = plt.plot(inputs, g2, 'co', inputs, g2_function(inputs), 'c-')
	g3_line, g3_curve = plt.plot(inputs, g3, 'ro', inputs, g3_function(inputs), 'r-')
	g4_line, g4_curve = plt.plot(inputs, g4, 'yo', inputs, g4_function(inputs), 'y-')
	g5_line, g5_curve = plt.plot(inputs, g5, 'bo', inputs, g5_function(inputs), 'b-')

	
	plt.figlegend((g1_line, g2_line, g3_line, g4_line, g5_line), ('Algo1:insertion' ,'Algo2:bulles' ,'Algo3:fusion','Algo4:rapide','Algo5:Tas'), 'upper right')
	plt.xlabel('la taille du tableau')
	plt.ylabel('le temps d\'execution')
	#plt.savefig(name + '.png')
	plt.show()
	plt.clf()


def plot_theorique(name, g1 , g2 , g3 , g4 , g5):
	plt.title(name)
	axis = np.arange(1, 10, 1)
	gg1 = np.array([g1(x) for x in axis])
	gg2 = np.array([g2(x) for x in axis])
	gg3 = np.array([g3(x) for x in axis])
	gg4 = np.array([g4(x) for x in axis])
	gg5 = np.array([g5(x) for x in axis])
	
	plt.axis([min(axis), max(axis), min(np.append(gg1,gg2,gg3,gg4,gg5)), max(np.append(gg1,gg2,gg3,gg4,gg5))])
	g1_line,  = plt.plot(axis, gg1, 'g--')
	g2_line,  = plt.plot(axis, gg2, 'b--')
	g3_line,  = plt.plot(axis, gg3, 'r--')
	g4_line,  = plt.plot(axis, gg4, 'c--')
	g5_line,  = plt.plot(axis, gg5, 'y--')

	plt.figlegend((g1_line , g2_line , g3_line , g4_line , g5_line), ('Algo1:insertion' ,'Algo2:bulles' ,'Algo3:fusion','Algo4:rapide','Algo5:Tas'), 'upper right')
	plt.xlabel('la taille du tableau')
	plt.ylabel('le temps d\'execution')
	#plt.savefig('Pire_Case.png')
	plt.show()
	plt.clf()
	

plot_theorique('Pire_Cas', lambda x: x**2, lambda x: x**2 , lambda x: x*log(x) , lambda x: x**2  ,lambda  x*log(x))

#name = 'Ordre aleatoire'
#g1_results = [0.002001 , 0.004507 , 0.008967 , 0.019399 , 0.043008 , 0.086016]
#g2_results = [14.629 , 60.693 , 248.038 , 998.726 , 4125.610 , 15000]
#g3_results = [0.029 , 0.043 , 0.072 , 0.129 , 0.270 , 0.578]
#g4_results = [0.015 , 0.033 , 0.062 , 0.132 , 0.325 , 2.700]
#g5_results = [0.008536 , 0.011043 , 0.021991 , 0.045623 , 0.045623 , 0.092964]

#plot_algo_complexity(name, g1_results, g2_results, g3_results , g4_results , g5_results )


#plot_theorique('tri insertion', lambda x: x**2, lambda x: x)
#plot_theorique('tri a bulle', lambda x: x**2, lambda x: x**2)
#plot_theorique('tri fusion', lambda x: x*log(x), lambda x: x*log(x))
#plot_theorique('tri rapide', lambda x: x**2, lambda x: x*log(x))
#plot_theorique('tri par tas', lambda x: x*log(x), lambda x: x*log(x))



