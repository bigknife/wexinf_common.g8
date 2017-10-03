package $name;format="snake"$.server.world.protocol

case class Order(
  orderNo: String,
  sku: String,
  productName: String,
  count: Int,
  price: String,
  user: String
)
