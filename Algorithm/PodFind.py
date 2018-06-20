#!/usr/bin/python
#coding=utf-8
import os, re, datetime,shutil
import json

class PodFind(object):
	def  __init__(self,root,targetList,targetPath,versionDic,specPath):
		self.root = root
		self.targetList = targetList
		self.resultFiles = []
		self.targetPath = targetPath
		self.versionDic = versionDic
		self.specPath   = specPath
		self.infoText 	= '/Users/heboyce/Desktop/info.md'
		fp = open(self.infoText,"a")
		fp.write('|Name|version|HomePage|Source|New Source|\n')
		fp.write('|---|---|---|---|---|\n')
		
		
	def findAllPath(self):
		for root, dirs, files in os.walk(self.root, topdown=True):
			for dir in dirs:
				if dir in self.targetList:
					print(root+'/'+dir)
					#self.getGitAndHomePageAddress(root+'/'+dir)
					self.copyToTargetPath(root+'/'+dir)
					
				
				
	def copyToTargetPath(self,sourcePath):
		targetPath = self.targetPath+'/'+os.path.basename(sourcePath)
		shutil.copytree(sourcePath, self.targetPath+'/'+os.path.basename(sourcePath))
		self.getGitAndHomePageAddress(targetPath)
		
	def getGitAndHomePageAddress(self,sourcePath):
		fp = open(self.infoText,"a")
		name = os.path.basename(sourcePath)
		for root, dirs, files in os.walk(sourcePath, topdown=True):
			for file in files:
				if self.versionDic.has_key(name):
					if cmp(self.versionDic[name], os.path.basename(root)) == 0:
						print('******--------')
						print(self.versionDic[name])
						print(file)
						print('------********')
						fp.write("|"+name)
						file_object = open(root+'/'+file)
						file_context = file_object.read()
						try:
							jsondata = json.loads(file_context)
							if jsondata.has_key('version'):
								print(jsondata['version'])
								fp.write("|"+jsondata['version'])
							else:
								print("no version")
								fp.write("|"+"No Ver")
							if jsondata.has_key('homepage'):
								print(jsondata['homepage'])
								fp.write("|"+jsondata['homepage'])
							else:
								print("no homepage")
								fp.write("|"+"No Homepage")
							if jsondata.has_key('source'):
								print(jsondata['source'])
							else:
								print("no source")
				
							if(jsondata['source'].has_key('git')):
								print("git--")
								print(jsondata['source']['git'])
								fp.write("|"+jsondata['source']['git'])
								fp.write("|"+'https://git.elenet.me/LPD-iOS/'+name.lower()+'.git'+'|\n')
								fp.flush()
								fp.close()
								#jsondata['source']['git'] = 'https://git.elenet.me/LPD-iOS/'+name.lower()+'.git'
								self.copyFileToNewFile(root+'/'+file,self.specPath+'/Normal/'+name+'/'+os.path.basename(root)+'/'+file)
							elif(jsondata['source'].has_key('http')):
								print('http--')
								print(jsondata['source']['http'])
								fp.write("|"+jsondata['source']['http'])
								fp.write('|No Git Address Please Check'+"|\n")
								fp.flush()
								fp.close()
								self.copyFileToNewFile(root+'/'+file,self.specPath+'/Other/'+name+'/'+os.path.basename(root)+'/'+file)
							else:
								print("thunder bolt")
								fp.write("|"+"Error"+"|\n")
								fp.flush()
								fp.close()
						except BaseException as e:
							print("Error Spec")
							print("3***************")
							fp.write("|"+"Error Spec"+"|\n")
							fp.flush()
							fp.close()
							print(file_context)
							print(root)
							print(file)
							self.copyFileToNewFile(root+'/'+file ,self.specPath+'/Except/'+name+'/'+os.path.basename(root)+'/'+file)
							print("4----------------")
					
	def copyFileToNewFile(self,sourcePath,targetFullPath):
		print('writeObjToFile')
		print(sourcePath)
		print(targetFullPath)
		self.mkdir(os.path.dirname(targetFullPath))
		shutil.copy(sourcePath, targetFullPath)
		
	def mkdir(self,path):
		if not os.path.isdir(path):
			self.mkdir(os.path.split(path)[0])
		else:
			return
		os.mkdir(path)
		

		
if __name__ == "__main__":
	targetList = ['FMDB']
	versionDic = {'FMDB':'2.7.2'}
	
	findObj = PodFind('/Users/heboyce/.cocoapods/repos/master/Specs', targetList,'/Users/heboyce/Desktop/TempGithub',versionDic,'/Users/heboyce/Desktop/TempSpec')
	
	findObj.findAllPath()
		
