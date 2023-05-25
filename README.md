# CuocDuaKyThu
Mô tả:
Mini project Cuộc đua kì thú trên Android là một trò chơi chạy đua giữa ba nhân vật. Người chơi sẽ phải đặt cược vào một nhân vật và sau đó click button Play. Nếu người chơi thắng sẽ nhận được 10 xu và thua sẽ bị trừ 5 xu.
Nếu người chơi không còn tiền thì người chơi sẽ không được chơi nữa.

Về mini project
- Gồm 3 checkbox giúp người chơi đặt cược (xử lý chỉ được chọn 1 như radio button)
- 3 seekbar mô tả tiến trình của 3 nhân vật
- 1 textview hiển thị điểm người chơi
Đối với xử lý tiến trình của nhân vật
- Sử dụng CountDownTimer để diễn tả trò chơi.
- Sinh một số ngẫu nhiên biểu thị tốc độ của nhân vật.
- Nhân vật nào tới đích trước thì sẽ cho dừng tất cả trò chơi lại và in ra nhân vật thắng.
- Khi click button Play thì sẽ disable seekbar để tránh người chơi gian lận
Đối với xử lý đặt cược
- Người chơi chỉ được chọn 1 checkbox
- Người chơi phải đặt cược trước khi chơi
- Sau khi click button play thì người chơi k được chọn lại tránh gian lận (disable)
Đối với xử lý điểm
- Kiểm tra đặt cược (kiểm tra checkbox và nhân vật nào được thắng)- thắng +10 thua -5
- Dưới 0 điểm thì k được chơi nữa.
