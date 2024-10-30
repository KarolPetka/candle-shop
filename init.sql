create table category
(
    id          bigint not null auto_increment,
    description varchar(255),
    name        varchar(255),
    primary key (id)
) engine = InnoDB;

create table order_item
(
    id         bigint  not null auto_increment,
    quantity   integer not null,
    product_id bigint,
    primary key (id)
) engine = InnoDB;

create table orders
(
    id              bigint not null auto_increment,
    customer_id     varchar(255),
    payment_method  varchar(255),
    shipping_option varchar(255),
    status          varchar(255),
    primary key (id)
) engine = InnoDB;

create table orders_products
(
    order_id    bigint not null,
    products_id bigint not null
) engine = InnoDB;

create table product
(
    id          bigint    not null auto_increment,
    burn_time   integer   not null,
    description varchar(255),
    name        varchar(255),
    price       float(53) not null,
    stock       integer   not null,
    weight      float(53) not null,
    category_id bigint,
    primary key (id)
) engine = InnoDB;

create table product_images
(
    product_id bigint not null,
    images     varchar(255)
) engine = InnoDB;

create table product_ingredients
(
    product_id  bigint not null,
    ingredients varchar(255)
) engine = InnoDB;

create table product_reviews
(
    product_id bigint not null,
    reviews_id bigint not null
) engine = InnoDB;

create table product_scents
(
    product_id bigint not null,
    scents     varchar(255)
) engine = InnoDB;

create table product_review
(
    id          bigint  not null auto_increment,
    comment     varchar(255),
    customer_id varchar(255),
    rating      integer not null,
    primary key (id)
) engine = InnoDB;

create table shipping_option
(
    id                 bigint    not null auto_increment,
    estimated_delivery varchar(255),
    name               varchar(255),
    price              float(53) not null,
    primary key (id)
) engine = InnoDB;

create table user
(
    id       bigint not null auto_increment,
    address  varchar(255),
    email    varchar(255),
    name     varchar(255),
    password varchar(255),
    phone    varchar(255),
    role     varchar(255),
    primary key (id)
) engine = InnoDB;

alter table orders_products
    drop index UKqmviv5y7625wak8tjq4nirybh;

alter table orders_products
    add constraint UKqmviv5y7625wak8tjq4nirybh unique (products_id);

alter table product_reviews
    drop index UK3ccouv5pw4emhrij6823d0vf7;

alter table product_reviews
    add constraint UK3ccouv5pw4emhrij6823d0vf7 unique (reviews_id);

alter table order_item
    add constraint FK551losx9j75ss5d6bfsqvijna foreign key (product_id) references product (id);

alter table orders_products
    add constraint FK95pvja3ijbda3gduk3ijaqvg9 foreign key (products_id) references order_item (id);

alter table orders_products
    add constraint FKe4y1sseio787e4o5hrml7omt5 foreign key (order_id) references orders (id);

alter table product
    add constraint FK1mtsbur82frn64de7balymq9s foreign key (category_id) references category (id);

alter table product_images
    add constraint FKi8jnqq05sk5nkma3pfp3ylqrt foreign key (product_id) references product (id);

alter table product_ingredients
    add constraint FKcjxxp1v84pkvofdwi58x85431 foreign key (product_id) references product (id);

alter table product_reviews
    add constraint FKrx805yeokktipito0qtnd0tpo foreign key (reviews_id) references product_review (id);

alter table product_reviews
    add constraint FKipftsx386s1e9e1lk5onryuh5 foreign key (product_id) references product (id);

alter table product_scents
    add constraint FKshsy5hkbiej0e5re4osafl4xj foreign key (product_id) references product (id);
