## 📗  다중 검색 조건을 지원하는 도서 목록 조회 시스템



### Swing과 JDBC를 통해 구현한 도서 목록 조회 시스템입니다.
* 📝  **제작 내용** :
   * 사용자가 선택한 검색 조건들로 쿼리가 작성되어 DB로부터 적절한 책 엔티티 목록을 받아오는 로직 구현 - StringBuilder를 사용해 입력 조건에 해당하는 적절한 where절을 이어붙여 동적으로 쿼리 구문을 완성 
   * 책 엔티티의 각 속성값에 따른 검색 조건 (책 이름, 출판사, 가격 범위(최소값, 최댓값 중 택1 혹은 전체선택 가능))
   * MVC패턴 적용 - Model(DAOList), View(ViewList.class), Controller(ControllerList.class) 
   * 문자열을 원소로하는 Vctor객체를 VO로 사용하여 책 엔티티와 매핑

* 🧑‍💻  **개발자** : 진명인

* **기술스택** :
  * Swing
  * Java
  * JDBC

* **스크린샷** :  </br>


&nbsp;&nbsp;&nbsp;&nbsp;![image (1)](https://github.com/user-attachments/assets/90fa96ef-a50f-4b7a-9451-8522d4df27f3)
