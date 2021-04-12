package finalGame;

public class Map {
	private short[][] map;//���� �迭 1�� �� �� -1�ϋ� ��, 0�� �� ���� �� ������
	private final short BLACK=1;
	private final short WHITE=-1;
	private boolean checkBNW=true;//�� �� ���� Ȯ��
	
	public Map(MapSize ms) {
		map=new short[ms.getSize()][];
		for(int i=0;i<map.length;i++) 
			map[i]=new short[ms.getSize()];
	}
	
	public short getBlack() {
		return BLACK;
	}
	public short getWhite() {
		return WHITE;
	}
	public short getXY(int y, int x) {
		return map[y][x];
	}
	public boolean getCheck() {
		return checkBNW;
	}
	
	public void changeCheck() {
		if(checkBNW) {
			checkBNW=false;
		}
		else {
			checkBNW=true;
		}
	}
	
	public void setMap(int y, int x) {
		//checkBNW�� Ȯ���ؼ� true�� �� map�� BLACK, false�� �� WHITE ����
		if(checkBNW) {
			map[y][x]=BLACK;
		}
		else {
			map[y][x]=WHITE;
		}
	}
	
	//�¸� Ȯ��
	public boolean winCheck(int x, int y) {
		 if (winCheckL(x, y) || winCheckLD(x, y) || winCheckLU(x, y)
				    || winCheckR(x, y)

				    || winCheckRD(x, y) || winCheckRU(x, y) || winCheckUp(x, y)
				    || winCheckDown(x, y)

				    || winCheckOneDown(x, y) || winCheckOneL(x, y)
				    || winCheckOneLD(x, y) || winCheckOneLU(x, y)

				    || winCheckOneR(x, y) || winCheckOneRD(x, y)
				    || winCheckOneUp(x, y) || winCheckOneRU(x, y)

				    || winCheckCenterLU(x, y) || winCheckCenterRL(x, y)
				    || winCheckCenterRU(x, y) || winCheckCenterUD(x, y)) {
				   return true;
				  } 
		 else {
				   return false;
				   }
	}
	
	public boolean winCheckUp(int x, int y) {
		try {
		   for (int i = y; i < y + 5; i++) {
		    if (map[y][x] != map[i][x])
		     return false;
		   }
		} catch (ArrayIndexOutOfBoundsException e) {
		   return false;
		 }
		return true;
	 }
	
	public boolean winCheckDown(int x, int y) {
		try {
		   for (int i = y; i > y - 5; i--) {
		    if (map[y][x] != map[i][x])
		     return false;
		  }
		} catch (ArrayIndexOutOfBoundsException e) {
		   return false;
		 }
		  return true;
	}


	public boolean winCheckRU(int x, int y) {
		try {
		   for (int i = y, z = x; i > y - 5; i--, z++) {
		    if (map[y][x] != map[i][z])
		     return false;
		   }
		} catch (ArrayIndexOutOfBoundsException e) {
		   return false;
		  }
		  return true;
	}

	
	public boolean winCheckLU(int x, int y) {
		try {
		   for (int i = y, z = x; i > y - 5; i--, z--) {
		    if (map[y][x] != map[i][z])
		     return false;
		   }
		 } catch (ArrayIndexOutOfBoundsException e) {
		   return false;
		  }
		  return true;
	}

	
	public boolean winCheckR(int x, int y) {
		try {
		   for (int z = x; z < x + 5; z++) {
		    if (map[y][x] != map[y][z])
		     return false;
		   }
		} catch (ArrayIndexOutOfBoundsException e) {
		   return false;
		  }
		  return true;
	}

	
	public boolean winCheckL(int x, int y) {
		try {
		   for (int z = x; z > x - 5; z--) {
		    if (map[y][x] != map[y][z] )
		    	return false;
		   }
		} catch (ArrayIndexOutOfBoundsException e) {
		   return false;
		  }
		  return true;
	}

	
	public boolean winCheckRD(int x, int y) {
		try {
		   for (int i = y, z = x; i < y + 5; i++, z++) {
		    if (map[y][x] != map[i][z]||i>(Omok.getBoardNum()-1)||z>(Omok.getBoardNum()-1)||i<0||z<0)
		    	return false;
		   }
		 } catch (ArrayIndexOutOfBoundsException e) {
		   return false;
		  }
		  return true;
	}

	
	public boolean winCheckLD(int x, int y) {
		try {
		   for (int i = y, z = x; i < y + 5; i++, z--) {
		    if (map[y][x] != map[i][z])
		    	return false;
		   }
		 } catch (ArrayIndexOutOfBoundsException e) {
		   return false;
		  }
		  return true;
	}

	//�� ĭ ����
	public boolean winCheckOneUp(int x, int y) {
  	    try {
			   for (int i = y - 1; i < y + 4; i++) {
			    if (map[y][x] != map[i][x])
			     return false;
			   }
		} catch (ArrayIndexOutOfBoundsException e) {
			   return false;
			 }
			  return true;
	 }

	//�� ĭ �Ʒ���
	 public boolean winCheckOneDown(int x, int y) {
		 try {
			   for (int i = y + 1; i > y - 4; i--) {
			    if (map[y][x] != map[i][x])
			     return false;
			   }
	  } catch (ArrayIndexOutOfBoundsException e) {
			   return false;
		 }
			  return true;
	}

	 //�� ĭ ������ �� �밢��
	 public boolean winCheckOneRU(int x, int y) {
		 try {
			   for (int i = y + 1, z = x - 1; i > y - 4; i--, z++) {
			    if (map[y][x] != map[i][z])
			     return false;
			   }
	  } catch (ArrayIndexOutOfBoundsException e) {
			   return false;
		 }
			  return true;
	}

	//�� ĭ ���� �� �밢��
	public boolean winCheckOneLU(int x, int y) {
		try {
			   for (int i = y + 1, z = x + 1; i > y - 4; i--, z--) {
			    if (map[y][x] != map[i][z])
			     return false;
			   }
		} catch (ArrayIndexOutOfBoundsException e) {
			   return false;
			  }
			  return true;
	}

	//�� ĭ ������
	public boolean winCheckOneR(int x, int y) {
		 try {
			   for (int z = x - 1; z < x + 4; z++) {
			    if (map[y][x] != map[y][z])
			     return false;
			   }
	  } catch (ArrayIndexOutOfBoundsException e) {
			   return false;
			  }
			  return true;
	}

	//�� ĭ ����
	public boolean winCheckOneL(int x, int y) {
		try {
			   for (int z = x + 1; z > x - 4; z--) {
			    if (map[y][x] != map[y][z])
			     return false;
			   }
		 } catch (ArrayIndexOutOfBoundsException e) {
			   return false;
			  }
			  return true;
	}

	//�� ĭ ������ �Ʒ� �밢��
	public boolean winCheckOneRD(int x, int y) {
		try {
			   for (int i = y - 1, z = x - 1; i < y + 4; i++, z++) {
			    if (map[y][x] != map[i][z] || i > (Omok.getBoardNum()-1) || z > (Omok.getBoardNum()-1) || i < 0|| z < 0)
			    	return false;
			   }
		} catch (ArrayIndexOutOfBoundsException e) {
			   return false;
		}
			  return true;
	}
	
	//�� ĭ ���� �Ʒ� �밢��
	public boolean winCheckOneLD(int x, int y) {
		try {
			   for (int i = y - 1, z = x + 1; i < y + 4; i++, z--) {
			    if (map[y][x] != map[i][z])
			     return false;
			   }
	 } catch (ArrayIndexOutOfBoundsException e) {

			   return false;
			  }
			  return true;
	 }


	//���� ���ٿ�
	 public boolean winCheckCenterUD(int x, int y) {
	  try {
			  for (int i = y - 2; i < y + 3; i++) {
			    if (map[y][x] != map[i][x])
			     return false;
			   }
	 } catch (ArrayIndexOutOfBoundsException e) {
			   return false;
			  }
			  return true;
	 }

	//���� ����Ʈ ����Ʈ
	public boolean winCheckCenterRL(int x, int y) {
		try {
			   for (int z = x - 2; z < x + 3; z++) {
			    if (map[y][x] != map[y][z])
			     return false;
			   }
		} catch (ArrayIndexOutOfBoundsException e) {
			   return false;
			  }
			  return true;
	 }

	 //���� ����Ʈ �밢��
	public boolean winCheckCenterRU(int x, int y) {
		try {
			   for (int i = y + 2, z = x - 2; i > y - 3; i--, z++) {
			    if (map[y][x] != map[i][z])
			     return false;
			   }
		} catch (ArrayIndexOutOfBoundsException e) {
			   return false;
			  }
			  return true;
	}

	//���� ������ �밢��
	 public boolean winCheckCenterLU(int x, int y) {
		try {
			   for (int i = y + 2, z = x + 2; i > y - 4; i--, z--) {
			    if (map[y][x] != map[i][z])
			     return false;
			   }
		} catch (ArrayIndexOutOfBoundsException e) {
			   return false;
			  }
			  return true;
	 }
}
