while True:
    a=int(input("낙하시킬 물체의 질량을 입력하세요.(단위: g)\n"))
    b=int(input("낙하시킬 물체의 높이 입력하세요.(단위: m)\n"))
    print("{0}g의 질량을 가진 물체를 {1}m의 높이에서 떨어뜨렸을때 받는 충격량 : {2}".format(a,b,int(a)*int(b)*9.8))
    if(a>=560):
        print("실험체가 사망하였습니다.")
    else:
        print("실험체가 살아남았습니다.")
    c= input("이 실험을 나가고 싶다면 \"예\"를 입력하시오. : ")
    if c=="예":
        break
    else:
        print("실험을 재시작합니다.")